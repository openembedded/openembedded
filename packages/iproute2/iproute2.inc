DESCRIPTION = "kernel routing and traffic control utilities"
SECTION = "base"
LICENSE = "GPL"
DEPENDS = "flex-native bison-native"

# This changed from iproute2 to iproute with version 2.6.20, so set to
# iproute in the recipe for 2.6.20 and newer versions.
DIRNAME ?= "${PN}"

# Set the DATE in the .bb file
SRC_URI = "http://developer.osdl.org/dev/iproute2/download/${P}-${DATE}.tar.gz"

S = "${WORKDIR}/${DIRNAME}-${PV}-${DATE}"

EXTRA_OEMAKE = "CC='${CC}' \
                KERNEL_INCLUDE=${STAGING_KERNEL_DIR}/include \
                DOCDIR=${docdir}/iproute2 \
                SUBDIRS='lib tc ip' \
                SBINDIR=/sbin"

do_install () {
        oe_runmake DESTDIR=${D} install
}

FILES_${PN} += "/usr/lib/tc/*"
FILES_${PN}-dbg += "/usr/lib/tc/.debug"
