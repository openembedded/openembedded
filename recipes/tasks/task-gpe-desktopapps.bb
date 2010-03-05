DESCRIPTION = "Additional desktop applications package for GPE Palmtop Environment"
PR = "r7"
LICENSE = "MIT"

inherit task

RDEPENDS_${PN} = "\
    sylpheed \
    firefox \
    thunderbird \
    galculator \
    gnumeric"

