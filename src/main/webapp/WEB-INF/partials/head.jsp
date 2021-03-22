<title>${param.title}</title>
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta2/css/bootstrap.css' integrity='sha512-zTLt9JxNhBSmCBcrxhMvLQFF2XI0DZ1WkWIYCuj/Z5NhK3o+bU092G2lgnLHuTIIap7rtJ8p45TV9GQP1B63Kw==' crossorigin='anonymous'/>
<script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta2/js/bootstrap.bundle.min.js' integrity='sha512-43iShtbiyImxjjU4a9rhXBy7eKtIsrpll8xKhe1ghKqh5NyfME8phZs5JRFZpRBe1si44WM3tNmnqMym7JRmDQ==' crossorigin='anonymous'></script>

<style>
    .comment-box {
        border: 1px solid black;
        background: whitesmoke;
    }
    #cardContainer{
        margin: 25px;
        padding: 15px;
        display: flex;
        flex-wrap: wrap;
    }

    #cardContainer>div{
        margin: 15px;
        width: 18rem;
    }
    #cardContainer img{
        height: 50%;
        object-fit: contain;
    }

    #adBoxes {
        margin: 0 auto;
        justify-content: center;
    }

    #cardContainer {
        justify-content: center;
        /*flex-wrap: wrap;*/
    }

    #profile-header {
        text-align: center;
    }

    @media screen and (min-width: 768px) {
        #adBoxes {
            margin: 0px;
        }

        #cardContainer {
            justify-content: space-between;
        }
    }
</style>