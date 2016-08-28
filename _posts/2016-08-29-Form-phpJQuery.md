
# Trigger form action via php wihout clicking submit

Use a hidden input.

<form action="myphp.php" name="form1" method="POST" />
   <input type="hidden" name="action" />
   <input onclick="setHidden(this)" type="button" value="paypal" />
   <input onclick="setHidden(this)" type="button" value="other" />
</form>

<script>
    function setHidden(element) {
       document.form1.action.value = element.value;
       document.form1.submit();
    }
 </script>
Then in PHP

if($_POST["action"] == "paypal") {
    header('Location: https://www.paypal.com/cgi-bin/webscr');
}
else if($_POST["action"] == "other") {
    header('Location: https://www.someotherwebsite.com/pay');
}
