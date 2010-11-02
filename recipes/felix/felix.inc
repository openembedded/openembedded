DESCRIPTION = "Apache Felix is an implementation of the OSGi Release 4 core framework specification."
LICENSE = "Apache-2.0"
HOMEPAGE = "http://felix.apache.org/site/index.html"

INC_PR = "r0"

inherit bug-java-library

#Fully Qualified Project Name.
FQPN="CHANGE_ME"

SRC_URI = "${APACHE_MIRROR}/felix/${FQPN}-${PV}-bin.tar.gz"
S = "${WORKDIR}/${FQPN}-${PV}"

PACKAGE_ARCH = "all"

FILES_${PN}="/usr/share/java/"

# override java-library's naming conventions
PACKAGES = ${PN}

# dummy to keep jar from being removed by java-library.bbclass
do_removebinaries() {
    :
}
