DESCRIPTION = "Additional desktop applications package for GPE Palmtop Environment"
FILE_PR = "r6"
LICENSE = "MIT"

inherit task

RDEPENDS_${PN} = "\
    sylpheed \
    firefox \
    thunderbird \
    galculator \
    gnumeric \
    gpdf"

