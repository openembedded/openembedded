DESCRIPTION = "Base task package for Java"
FILE_PR = "r2"
LICENSE = "MIT"

inherit task

RDEPENDS_${PN} = "\
    cacao \
    classpath-awt \
    java2-runtime \
    librxtx-java \
 "
