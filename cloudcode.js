Parse.Cloud.afterSave("SwitchState", function(request) {
  var pushQuery = new Parse.Query(Parse.Installation);
 
  Parse.Push.send({
        where: pushQuery,
        data: {
            alert: "Door opened - theft!",
            sound: "default"
              }
        },{
        success: function(){
           response.success('true');
        },
        error: function (error) {
           response.error(error);
        }
      });
});