DESCRIPTION = "internet server functionality"
PR = "r1"
LICENSE = "MIT"

inherit task

RDEPENDS_${PN} = "\
    lighttpd \
    php \
    php-cli \
    php-cgi \
    mysql5 \
    perl \
    proftpd \
    "

