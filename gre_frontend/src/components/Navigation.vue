
<template>
  <div>
    
    <nav class="navbar navbar-light bg-light navbar-expand-lg">
      <a class="navbar-brand">GRE VOCABULARY</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

         <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
              <router-link to="/card" class="nav-link">Card</router-link>
            </li>
            <li class="nav-item">
              <router-link to="/list" class="nav-link">List</router-link>
            </li>
          </ul>
         </div>
      
      
    </nav>
  </div>
</template>

<script>
export default {
    name: "Navigation",
}
</script>

<style scoped>
</style>