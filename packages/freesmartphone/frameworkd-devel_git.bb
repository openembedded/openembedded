require frameworkd_git.bb
FILESPATH = "${FILE_DIRNAME}/frameworkd"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/framework.git;protocol=git;branch=master \
  file://frameworkd \
  file://frameworkd.conf \
"
