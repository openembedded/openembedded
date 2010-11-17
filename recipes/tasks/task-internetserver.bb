DESCRIPTION = "internet server functionality"
PR = "r0"
LICENSE = "MIT"

inherit task

RDEPENDS_${PN} = "\
    lighttpd \
    php \
    mysql5 \
    perl \
    proftpd \
    "

