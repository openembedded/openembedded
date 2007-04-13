DESCRIPTION = "SDK packages for Opie"
PR = "r6"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

PACKAGES = "task-sdk-opie"

RDEPENDS_task-sdk-opie = "\
    libopiebluez2 \
    libopiedb2 \
    libopiecore2 \
    libopienet2 \
    libopiepim2 \
    libopieui2 \
    libqpe1 \
    qte \
    libqtaux2 \
    libmailwrapper"
