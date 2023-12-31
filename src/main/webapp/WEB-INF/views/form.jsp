<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>

    <link rel="stylesheet" href="<c:url value="../../resources/css/style.css"/>"/>


    <script>



    </script>

    <script src="<c:url value="../../resources/js/app.js"/>"></script>

</head>
<body>


<jsp:include page="form_header.jsp"/>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>

        <form action="form" method="post">
            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>
                <div class="form-group form-group--checkbox">

    <c:forEach var="category" items="${categories}">
        <label>
            <input
                    type="checkbox"
                    name="categories"
                    id="categories"
                    value="${category.id}"
            />
            <span class="checkbox"></span>
            <span class="description">${category.name}</span>
        </label>
    </c:forEach>



                </div>


                <div class="form-group form-group--buttons">
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 2 -->
            <div data-step="2">
                <h3>Podaj liczbę worków (60 litrów), w które spakowałeś/aś rzeczy:</h3>

                <div class="form-group form-group--inline">
                    <label>
                        Liczba worków (60 litrów):
                        <input type="number" name="quantity" id="quantity" step="1" min="1" />
                    </label>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>



            <!-- STEP 4 -->
            <div data-step="3">
                <h3>Wybierz organizacje, której chcesz pomóc:</h3>

<%--                <div class="form-group form-group--checkbox">--%>
<%--&lt;%&ndash;                    <label>&ndash;%&gt;--%>
<%--                        <c:forEach items="${institutions}" var="institution">--%>
<%--                            <div>--%>
<%--                                <input type="radio" name="donation.institution.id" value="${institution.id}" id="organization-${institution.id}">--%>
<%--                                <label for="organization-${institution.id}" class="checkbox radio"></label>--%>
<%--                                <div class="description">--%>
<%--                                    <div class="title" id="institution-name">${institution.name}</div>--%>
<%--                                    <div class="subtitle">${institution.description}</div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </c:forEach>--%>
<%--&lt;%&ndash;                    </label>&ndash;%&gt;--%>
<%--                </div>--%>

                <div class="form-group form-group--checkbox">
                    <c:forEach items="${institutions}" var="institution">
                        <label>
                            <input type="radio" name="donation.institution.id" value="${institution.id}" id="organization-${institution.id}" />
                            <span class="checkbox radio"></span>
                            <span class="description">
        <div class="title">${institution.name}</div>
        <div class="subtitle">${institution.description}</div>
      </span>
                        </label>
                    </c:forEach>
                </div>


                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 5 -->
            <div data-step="4">
                <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Ulica <form:input path="donation.street" id="street" name="street"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Miasto <form:input path="donation.city" id="city" name="city"  /> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Kod pocztowy <form:input path="donation.zipCode"  id="zipCode" name="zipCode" />
                            </label>
                        </div>


                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Data <form:input type="date" path="donation.pickUpDate" id="pickupDate" name="pickupDate" /> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Godzina <form:input type="time" path="donation.pickUpTime" id="pickupTime" name="pickupTIme" /> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Uwagi dla kuriera
                                <form:textarea path="donation.pickUpComment" rows="5" id="pickupComment" name="pickupComment" />
                            </label>
                        </div>
                    </div>
                </div>



                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 6 -->
            <div data-step="5">
                <h3>Podsumowanie Twojej darowizny</h3>

                <div class="summary">
                    <div class="form-section">
                        <h4>Przekazujesz:</h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span><span class="quantity"></span>

                            </li>

                            <li>
                                <span class="icon icon-hand"></span>
                                <span class="institution">(institution name)</span  <%--institution name--%>
                                >
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Miejsce odbioru:</h4>
                            <ul>
                                <li class="street"></li>
                                <li class="city"></li>
                                <li class="zipCode"></li>

                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Odbiór paczki:</h4>
                            <ul>
                                <li class="pickupDate"></li>
                                <li class="pickupTime"></li>
                                <li class="pickupComment" ></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="submit" class="btn">Potwierdź</button>
                </div>
            </div>
        </form>
    </div>
</section>

<jsp:include page="footer.jsp"/>



</body>
</html>

