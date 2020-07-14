export default function api(link, method) {
    var result;
    fetch('http://localhost:8080/api/v1' + link)
    .then(response => response.json())
    .then(data => result = data);
    return result;
}