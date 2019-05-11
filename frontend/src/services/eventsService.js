import http from "./httpService";

const apiEndpoint = "/api/v1/events";

export function getEvents() {
  return http.get(apiEndpoint);
}
