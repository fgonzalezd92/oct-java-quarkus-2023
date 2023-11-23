import {gql, useQuery} from '@apollo/client';
import {useState, useEffect} from "react";


const companiesQuery = gql`
    query fetchCompanies {
        companies: allCompanies {
            id
            name
            ceo
        }
    }
`;

export default function CompaniesViewUsingQuery() {
    const {loading, error, data} = useQuery(companiesQuery);
    const [companies, setCompanies] = useState([]);
    useEffect(() => {
        if (loading) {
            console.log("Loading")
        }
        if (error) {
            console.log(error.message)
        }
        if (data) {
            setCompanies(data.companies);
        }
    }, [data]);
    return (<div>
        <h1>Companies using useQuery</h1>
        <ul>
            {
                companies.map(company => <li key={company.id}>{company.name}, {company.ceo}</li>)
            }
        </ul>
    </div>);
}