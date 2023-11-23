import {gql, useLazyQuery, useQuery} from '@apollo/client';
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

export default function CompaniesViewUsingLazyHooks() {
    const [fetchCompanies, {loading, error, data}] = useLazyQuery(companiesQuery); // [0] = fetchCompanies, [1] = {loading, error, data}
    const [companies, setCompanies] = useState([]);
    const [message, setMessage] = useState([]);
    useEffect(() => {
        if (loading) {
            setMessage("Loading")
        }
        if (error) {
            setMessage(error.message)
        }
        if (data) {
            setMessage("Loaded companies")
            setCompanies(data.companies);
        }
    }, [data]);
    return (<div>
        <h1>Companies using useLazyQuery</h1>
        <button onClick={() => fetchCompanies()}>Fetch Companies</button>
        <ul>
            {
                companies.map(company => <li key={company.id}>{company.name}, {company.ceo}</li>)
            }
        </ul>
    </div>);
}