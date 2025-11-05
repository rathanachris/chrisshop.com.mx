document.addEventListener("DOMContentLoaded", function() {
  const input = document.querySelector(".search input");

  // ចុច Enter ដើម្បីស្វែងរក
  input.addEventListener("keydown", async function(e) {
    if (e.key === "Enter") {
      const query = input.value.trim();
      if (!query) return;

      // សរសេរ URL របស់ API នៅទីនេះ
      const apiUrl = `https://api.gin.go/search?q=${encodeURIComponent(query)}`;

      try {
        const res = await fetch(apiUrl);
        const data = await res.json();

        // បង្ហាញលទ្ធផលសាមញ្ញ (អាចប្រើ alert ឬ UI ផងបាន)
        alert("លទ្ធផលស្វែងរកសម្រាប់ '" + query + "':\n" + JSON.stringify(data, null, 2));
      } catch (err) {
        alert("មានបញ្ហាពេលភ្ជាប់ទៅ API!\n" + err.message);
      }
    }
  });
});
