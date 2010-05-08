require ti-dmai.inc

DEFAULT_PREFERENCE = "-1"

PV = "1.0+svnr${SRCPV}"

# This package has high dependence on kernel, use kernel PR as base and append a local version
PR = "${MACHINE_KERNEL_PR}"
PR_append = "l"

DMAIBRANCH_dm6446     = "trunk"
DMAIBRANCH_dm6467     = "branches/GITPSP_INT_101009"
DMAIBRANCH_omap3      = "trunk"
DMAIBRANCH_dm355      = "branches/GITPSP_INT_101009"
DMAIBRANCH_dm365      = "branches/GITPSP_INT_101009"
DMAIBRANCH_omapl137   = "trunk"
DMAIBRANCH_omapl138   = "trunk"
DMAIBRANCH           ?= "<UNDEFINED_DMAIBRANCH>"

SRCREV_dm6446         = "423"
SRCREV_dm6467         = "441"
SRCREV_omap3          = "423"
SRCREV_dm355          = "424"
SRCREV_dm365          = "441"
SRCREV_omapl137       = "423"
SRCREV_omapl138       = "423"
SRCREV               ?= "<UNDEFINED_SRCREV>"
