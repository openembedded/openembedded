require frameworkd_git.bb

SRC_URI = "${FREESMARTPHONE_GIT}/framework.git;protocol=git;branch=stabilization/master \
           file://frameworkd \
           file://frameworkd.conf"
