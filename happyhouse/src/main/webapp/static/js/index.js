window.onload = function () {
    $.ajax({
        url: "http://localhost:8080/address/states",
        type: "GET",
        data: {},
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
        state_text = $("#state option:checked").text();

        $.ajax({
            url: "http://localhost:8080/address/cities",
            type: "GET",
            data: {
                stateCode: state_val
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

    $("#city").change(function () {
        cityCode = $(this).val();

        if (cityCode != undefined) {
            let url = `house/items?cityCode=${cityCode}`;

            location.href = url;
        } else {
            console.log(state_val);
            console.log(city_val);
            console.log(dong_val);

            alert("빈 칸이 있습니다!");
        }
    });
};
