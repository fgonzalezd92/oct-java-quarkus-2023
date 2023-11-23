import  {gql, ApolloClient, InMemoryCache} from '@apollo/client';
import {useState, useEffect} from "react";

const apolloClient = new ApolloClient({
    uri: "http://localhost:8080/graphql", cache: new InMemoryCache(), // defaultOptions: {
});

const companiesQuery = gql`
    query fetchCompanies {
        companies: allCompanies {
            id
            name
            ceo
        }
    }
`;

export default function CompaniesView() {
    const [companies, setCompanies] = useState([]);
    useEffect(() => {
        apolloClient
            .query({query: companiesQuery})
            .then((result) => {
                setCompanies(result.data.companies);
            });
    }, []);
    return (<div>
        <h1>Companies</h1>
        <ul>
            {
                companies.map(company => <li key={company.id}>{company.name}, {company.ceo}</li>)
            }
        </ul>
    </div>);
}