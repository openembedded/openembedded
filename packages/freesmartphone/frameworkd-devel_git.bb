require frameworkd_git.bb
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/frameworkd"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/framework.git;protocol=git;branch=master \
  file://frameworkd \
  file://frameworkd.conf \
"
