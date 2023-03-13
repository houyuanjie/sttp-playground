import { defineConfig } from "vite";

export default defineConfig({
  resolve: {
    alias: {
      "@scala": "target/scala-3.2.2/sttp-playground-fastopt",
    },
  },
});
