require felix.inc

DESCRIPTION = "R4 Compliant OSGi logger bundle"

PR = "${INC_PR}.1"

RCONFLICTS="concierge"

FQPN="org.apache.felix.log"

datadir_java = ${datadir}/java/bundle/

FILES_${PN}="${datadir_java}"

addtask prep_install after do_compile before do_install
do_prep_install(){
   install -m 0644 org.apache.felix.log-${PV}.jar ${S}/${BPN}.jar
}

SRC_URI[md5sum] = "95d51e8f9750d6f9839dbd71c0a42f26"
SRC_URI[sha256sum] = "1b5a71515122e2a08938a98f94188a741bfa8a1db9337669396a415a2896d85c"
