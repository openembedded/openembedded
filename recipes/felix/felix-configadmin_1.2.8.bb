require felix.inc

DESCRIPTION = "R4 Compliant OSGi Config Admin implementation."

PR = "${INC_PR}.1"

FQPN="org.apache.felix.configadmin"

datadir_java = ${datadir}/java/bundle/

FILES_${PN}="${datadir_java}"

addtask prep_install after do_compile before do_install
do_prep_install(){
   install -m 0644 ${FQPN}-${PV}.jar ${S}/${BPN}.jar
}

SRC_URI[md5sum] = "bccdf944cc2ba6b51af47dc344ec00b6"
SRC_URI[sha256sum] = "0fab455db897b1651781433fa5829007b4c89ad4eb89e226c4b41e902aaa34bd"
