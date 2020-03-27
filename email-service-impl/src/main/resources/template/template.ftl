<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Title</title>
    <style>
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body{
            font-family: SimSun;
        }
        section{
            display:block;
            margin: 20px 10px;
        }
        .title{
            text-align: center;
        }
        .preface p{
            line-height: 30px;
        }
        .preface p.content{
            text-indent: 2em;
        }
        section > table{
            table-layout: fixed;
            width: 100%;
            margin: 20px 0px;
            text-align:center;
            word-wrap:break-word;
        }
        section table td{
            padding:5px 0px;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th><font color="red">*</font>税率(%)</th>
        <th><font color="red">*</font>折扣(%)</th>
        <th><font color="red">*</font>单价</th>
        <th><font color="red">*</font>小计</th>
        <th width="10"></th>
    </tr>
    <#list list as item>
        <tr>
            <td>${item.taxRate}</td>
            <td>${item.discount}</td>
            <td>${item.quotaPrice}</td>
            <td>${item.totalAmount}</td>
        </tr>
    </#list>
</table>
</body>
</html>