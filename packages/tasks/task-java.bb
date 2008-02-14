DESCRIPTION = "Base task package for Java"
PR = "r1"
LICENSE = "MIT"

inherit task

RDEPENDS_${PN} = "\
    cacao \
    classpath-awt \
    java2-runtime \
    librxtx-java \
    logic-analyzer \
 "
