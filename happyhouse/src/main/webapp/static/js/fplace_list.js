window.onload = function () {
    $.ajax({
        url: "http://localhost:8080/address/states",
        type: "GET",
        data: {

        },
        dataType: "json",
        success: function (response) {        	
            let code = ``;
            $.each(response, function (index, item) {
                code += `<option value="${item.code}">${item.name}</option>`;
            });
            $("#state").empty().append('<option value="">시도선택</option>').append(code);
        },
        error: function (xhr, status, msg) {
            console.log("상태값 : " + status + " Http에러메시지 : " + msg);
        },
    });

    $(document).on("change", "#state", function () {
        state_val = $(this).val();

        $.ajax({
            url: "http://localhost:8080/address/cities",
            type: "GET",
            data: {
                stateCode : state_val
            },
            dataType: "json",
            success: function (response) {
                let code = ``;
                $.each(response, function (index, item) {
                    code += `<option value="${item.code}">${item.name}</option>`;
                });
                $("#city").empty().append('<option value="">구군선택</option>').append(code);
            },
            error: function (xhr, status, msg) {
                console.log("상태값 : " + status + " Http에러메시지 : " + msg);
            },
        });
    });

    $(document).on("change", "#city", function () {
        city_val = $(this).val();

        $.ajax({
            url: "http://localhost:8080/address/dongs",
            type: "GET",
            data: {
                cityCode : city_val
            },
            dataType: "json",
            success: function (response) {
                let code = ``;
                $.each(response, function (index, item) {
                    code += `<option value="${item.code}">${item.name}</option>`;
                });
                $("#dong").empty().append('<option value="">동선택</option>').append(code);
            },
            error: function (xhr, status, msg) {
                console.log("상태값 : " + status + " Http에러메시지 : " + msg);
            },
        });
    });
};

let deletePlace = function (no) {
	if(confirm("정말 삭제하시겠습니까?")) {
		$.ajax({
	        url: "http://localhost:8080/place/delete",
	        type: "post",
	        data: {
	            favId : no
	        },
	        success: function (response) {        	
	            location.href = "/place/items";
	        },
	        error: function (xhr, status, msg) {
	            console.log("상태값 : " + status + " Http에러메시지 : " + msg);
	        },
	    });
	}
}