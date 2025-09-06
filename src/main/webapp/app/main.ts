import { createApp } from 'vue';
import AppVue from './AppVue.vue';
import router from './router';
// seed4j-needle-main-ts-import

const app = createApp(AppVue);
app.use(router);
// seed4j-needle-main-ts-provider
app.mount('#app');
