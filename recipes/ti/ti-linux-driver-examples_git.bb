require ti-linux-driver-examples.inc

SRCREV = "afa28447addb2fadd9daf5c94c6cf46d8c855d05"

PV = "git-${MACHINE_KERNEL_PR}-gitr${SRCREV}"
PR_append = "d"

SRC_URI = "git://arago-project.org/git/projects/examples-davinci.git;protocol=git \
  file://0001-linux-davinci-example-add-make-install-target.patch \
"

