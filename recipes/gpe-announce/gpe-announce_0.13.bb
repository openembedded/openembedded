inherit gpe

DEPENDS = "libsoundgen libschedule gtk+ libgpewidget"
LICENSE = "GPL"
PR = "r1"

SRC_URI += " \
            file://fix-esound.diff;patch=1 \
            file://fix-install.diff;patch=1 \
           "

SRC_URI[md5sum] = "74ca3a6e37c9d9ae9fe2c50fc6d8350f"
SRC_URI[sha256sum] = "63490b00244b0e6d7b54205e0d27ab22784ad0b328c7fa3e56aa0133677884fe"
