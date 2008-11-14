require frameworkd_git.bb
FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/frameworkd', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"

PR="r1"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/framework.git;protocol=git;branch=master \
  file://frameworkd \
  file://frameworkd.conf \
"
