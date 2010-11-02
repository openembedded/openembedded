require felix.inc

PR = "${INC_PR}.1"

FQPN="org.apache.felix.main.distribution"

SRC_URI = "${APACHE_MIRROR}/felix/${FQPN}-${PV}-project.tar.gz"

FILES_${PN}="/usr/share/java/"

addtask prep_install after do_compile before do_install
do_prep_install(){
   install -m 0644 bin/${PN}.jar ${S}
}

SRC_URI[md5sum] = "aebdc76fe950e2ce01f1b41f1ff1f184"
SRC_URI[sha256sum] = "9a6a8f420065d3b97c58c8a564c8c5c77d893002e134948afec6d3245a6b3edc"
