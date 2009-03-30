DESCRIPTION = "Additional desktop applications package for GPE Palmtop Environment"
PR = "r6"
LICENSE = "MIT"

inherit task

RDEPENDS_${PN} = "\
    sylpheed \
    firefox \
    thunderbird \
    galculator \
    gnumeric \
    gpdf"

