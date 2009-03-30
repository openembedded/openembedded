DESCRIPTION = "SDK packages for Opie"
PR = "r7"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

PALMTOP_USE_MULTITHREADED_QT ?= "yes"

PACKAGES = "task-sdk-opie"

RDEPENDS_task-sdk-opie = "\
    libopiebluez2 \
    libopiedb2 \
    libopiecore2 \
    libopienet2 \
    libopiepim2 \
    libopieui2 \
    libqpe-opie \
    ${@base_conditional("PALMTOP_USE_MULTITHREADED_QT", "yes", "qte-mt", "qte", d)} \
    libqtaux2 \
    libmailwrapper"
