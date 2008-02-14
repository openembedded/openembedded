DESCRIPTION = "Task package for Java GTK applications"
PR = "r0"
LICENSE = "MIT"

inherit task

RDEPENDS_${PN} = "\
    classpath-awt \
    librxtx-java \
    librxtx-jni \
    libswt3.4-gtk-java \
    logic-analyzer \
 "
