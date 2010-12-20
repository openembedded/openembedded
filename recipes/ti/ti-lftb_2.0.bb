require ti-lftb.inc

SRCREV = "3d0be58aee659ef7e8eda43e916172bab300235f"

PR = "${MACHINE_KERNEL_PR}+${INC_PR}"
PR_append = "a"

SRC_URI = "git://arago-project.org/git/projects/test-automation/target-code/psp/lftb.git;protocol=git \
"
