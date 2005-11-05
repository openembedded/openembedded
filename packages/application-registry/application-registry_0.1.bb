PR = "r3"

DESCRIPTION = "additional application registry files"
DEPENDS = "shared-mime-info"
RDEPENDS = "shared-mime-info"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "MIT"
SRC_URI = "file://abiword.applications \
           file://firefox.applications \
           file://gnumeric.applications \
           file://gpe-calendar.applications \
           file://gpe-contacts.applications \
           file://ipkg.applications" 


do_install_append () {
        mkdir -p ${D}${datadir}/application-registry
        install -m 0644 ${WORKDIR}/*.applications ${D}${datadir}/application-registry/
}

