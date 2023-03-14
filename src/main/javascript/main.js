import { openweather } from "scalajs:main.js";

const promise = openweather();
promise.then(console.log);
