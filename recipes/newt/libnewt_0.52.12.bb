DESCRIPTION = "Newt is a programming library for color text mode, widget based user interfaces"
HOMEPAGE = "https://fedorahosted.org/newt/"
SECTION = "libs"
LICENSE = "LGPL"

# slang needs to be >= 2.2
DEPENDS = "slang popt"

PR = "r1"

SRCREV = "c3c7be75f6ef1adfc2be5f99c1e8ef3f0ab58c38"
SRC_URI = "git://git.fedorahosted.org/git/newt;protocol=git \
           file://include-without-python.patch"
S = "${WORKDIR}/git"

EXTRA_OECONF = "--without-python --without-tcl"

inherit autotools

PACKAGES_prepend = "whiptail "

do_configure_prepend() {
    sh autogen.sh
}

FILES_whiptail = "${bindir}/whiptail"
