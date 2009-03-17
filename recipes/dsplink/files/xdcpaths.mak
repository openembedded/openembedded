#
#  ======== xdcpaths.mak ========
#  definition of XDC paths and commands
#
#  This makefile constructs the "search path" for the XDC tools where it finds
#  numerous components and packages needed to build Codec Engine examples and
#  programs.
#
#  USER NOTE:
#  1) you must specify various <component>_INSTALL_DIRs directores below to
#     reflect your installation, where <component> is CE for Codec Engine,
#     BIOS for DSP/BIOS, etc.
#  2) you must specify compiler path and name in CGTOOLS_* variables below
#  3) you can remove some of the devices from the "DEVICES" list and/or remove
#     some of the types of binaries from the "PROGRAMS" list to reduce
#     the build time (and possibly avoid checking for presence of a component
#     you don't need)



# (Optional) Remove from this list the devices you're not interested in building
DEVICES  := DM6446 DM355 DM6437 DM648 DM6467

# (Optional) Remove from the list the types of programs you're not intersted in
# building:
# APP_CLIENT -- Arm client for codecs running on the DSP, on dual-CPU systems
# DSP_SERVER -- DSP server with the codecs, running on the DSP, on dual-CPUs
# APP_LOCAL  -- Client+codecs in a single program, whether Arm only or DSP only
PROGRAMS := APP_CLIENT DSP_SERVER APP_LOCAL


# (Mandatory) Specify where various components are installed.
# What you need depends on what device(s) you're building for, what type(s) of
# programs you are building for, and whether your Codec Engine distribution
# is a "big" one that contains all the minor components in its "cetools"
# directory. The legend:
# CE      - Codec Engine (needed for Arm and for DSP)
# XDC     - XDC tools (Arm and DSP)
# BIOS    - DSP/BIOS (DSP only)
# XDAIS   - XDAIS header files (Arm and DSP)
# FC      - Framework components, various resource managers (ARM and DSP)
# CMEM    - Continuous memory manager (Arm only)
# DSPLINK - Arm<->DSP communication software (Arm + DSP)
#
# you can omit directory specifications for the components you think you don't
# need (will be warned if you do, based on your DEVICES + PROGRAMS selection
# above).

CE_INSTALL_DIR 	      := SEDME_S
XDC_INSTALL_DIR       := SEDME_XDCTOOLSUNPACKDIR
BIOS_INSTALL_DIR      := SEDME_BIOSUNPACKDIR

# no need to specify the installation directories below if your CE installation
# has cetools/ directory on top
USE_CETOOLS_IF_EXISTS := 1
XDAIS_INSTALL_DIR     := _your_xDAIS_installation_directory/xdais_6_10_01
DSPLINK_INSTALL_DIR   := _your_DSPLink_installation_directory/dsplink-davinci-v1.50-prebuilt
CMEM_INSTALL_DIR      := _your_CMEM_installation_directory/cmem_2_10
FC_INSTALL_DIR        := _your_FC_installation_directory/framework_components_2_10_01
BIOSUTILS_INSTALL_DIR := _your_BIOSUTILS_installation_directory/biosutils


# (Mandatory) specify correct compiler paths and names for the architectures
# you'll be building for:

# compiler path and name for Montavista Arm 9 toolchain. NOTE: make sure the
# directory you specify has a "bin" subdirectory
CGTOOLS_MVARM9 = /db/toolsrc/library/tools/vendors/mvl/arm/mvl4.0-new/montavista/pro/devkit/arm/v5t_le
CC_MVARM9      = bin/arm_v5t_le-gcc

# compiler path and name for TI C64x toolchain. NOTE: make sure the
# directory you specify has a "bin" subdirectory
CGTOOLS_C64P = /db/toolsrc/library/tools/vendors/ti/c6x/6.0.16/Linux
CC_C64P      = bin/cl6x

# -----------------------------------------------------------------------------

# figure out what categories of devices we are to build for
ifneq (,$(findstring DM6446,$(DEVICES)))
    DEVICES_DAVINCI := 1
endif    
ifneq (,$(findstring DM6467,$(DEVICES)))
    DEVICES_DAVINCI := 1
endif    
ifneq (,$(findstring DM355,$(DEVICES)))
    DEVICES_ARMONLY := 1
endif    
ifneq (,$(findstring DM6437,$(DEVICES)))
    DEVICES_DSPONLY := 1
endif    
ifneq (,$(findstring DM648,$(DEVICES)))
    DEVICES_DSPONLY := 1
endif    

# determine which components are necessary based on DEVICES and PROGRAMS
REQUIRE_CE    := 1
REQUIRE_XDC   := 1
REQUIRE_XDAIS := 1
REQUIRE_FC    := 1

ifneq (,$(findstring DM6446,$(DEVICES)))
    ifneq (, $(findstring APP_CLIENT, $(PROGRAMS) ))
        REQUIRE_LINK := 1
        REQUIRE_CMEM := 1
    endif
    ifneq (, $(findstring DSP_SERVER, $(PROGRAMS) ))
        REQUIRE_LINK := 1
        REQUIRE_BIOS := 1
    endif
endif

ifneq (,$(findstring DM6467,$(DEVICES)))
    ifneq (, $(findstring APP_CLIENT, $(PROGRAMS) ))
        REQUIRE_LINK := 1
        REQUIRE_CMEM := 1
    endif
    ifneq (, $(findstring DSP_SERVER, $(PROGRAMS) ))
        REQUIRE_LINK := 1
        REQUIRE_BIOS := 1
    endif
endif

ifneq (,$(findstring DM355,$(DEVICES)))
    ifneq (, $(findstring APP_LOCAL, $(PROGRAMS) ))
        REQUIRE_CMEM := 1
    endif
endif

ifneq (,$(findstring DM6437,$(DEVICES)))
    ifneq (, $(findstring APP_LOCAL, $(PROGRAMS) ))
        REQUIRE_BIOS := 1
    endif
endif

ifneq (,$(findstring DM648,$(DEVICES)))
    ifneq (, $(findstring APP_LOCAL, $(PROGRAMS) ))
        REQUIRE_BIOS := 1
    endif
endif


# Build the XDC path from the necessary components, verifying along the way
# that the required compoments are present
XDC_PATH :=

ERRMSG = which is invalid (could not find file "$(TEST_FILE)"). Set this in <codec engine examples>/xdcpaths.mak! See the build documentation to correct this error.

# CE_INSTALL_DIR is the location of your Codec Engine.
ifeq ($(REQUIRE_CE), 1)
    TEST_FILE := $(CE_INSTALL_DIR)/packages/ti/sdo/ce/package.xdc
    ifeq ($(wildcard $(TEST_FILE)),)
        $(error CE_INSTALL_DIR is set to "$(CE_INSTALL_DIR)", $(ERRMSG))
    endif
    XDC_PATH := $(CE_INSTALL_DIR)/packages
endif

# Add cetools to XDCPATH if 1) $(USE_CETOOLS_IF_EXISTS) is set, and
# 2) the CE distribution has "cetools/"
USING_CETOOLS := 0
ifeq ($(USE_CETOOLS_IF_EXISTS), 1)
    ifneq ($(wildcard $(CE_INSTALL_DIR)/cetools),)
        USING_CETOOLS := 1
        XDC_PATH := $(CE_INSTALL_DIR)/cetools/packages;$(XDC_PATH)
    endif
endif
ifeq ($(USING_CETOOLS),0)
    # XDAIS_INSTALL_DIR is the location of your XDAIS distribution
    ifeq ($(REQUIRE_XDAIS), 1)
        TEST_FILE := $(XDAIS_INSTALL_DIR)/packages/ti/xdais/package.xdc
        ifeq ($(wildcard $(TEST_FILE)),)
            $(error XDAIS_INSTALL_DIR is set to "$(XDAIS_INSTALL_DIR)", $(ERRMSG))
        endif
        XDC_PATH := $(XDC_PATH);$(XDAIS_INSTALL_DIR)/packages
    endif

    # DSPLINK_INSTALL_DIR is the location of your DSPLINK distribution
    ifeq ($(REQUIRE_LINK), 1)
        TEST_FILE := $(DSPLINK_INSTALL_DIR)/packages/dsplink/gpp/package.xdc
        ifeq ($(wildcard $(TEST_FILE)),)
            $(error DSPLINK_INSTALL_DIR is set to "$(DSPLINK_INSTALL_DIR)", $(ERRMSG))
        endif
        XDC_PATH := $(XDC_PATH);$(DSPLINK_INSTALL_DIR)/packages
    endif

    # CMEM_INSTALL_DIR is the location of your CMEM distribution
    ifeq ($(REQUIRE_CMEM), 1)
        TEST_FILE := $(CMEM_INSTALL_DIR)/packages/ti/sdo/linuxutils/cmem/package.xdc
        ifeq ($(wildcard $(TEST_FILE)),)
            $(error CMEM_INSTALL_DIR is set to "$(CMEM_INSTALL_DIR)", $(ERRMSG))
        endif
        XDC_PATH := $(XDC_PATH);$(CMEM_INSTALL_DIR)/packages
    endif

    # FC_INSTALL_DIR is the location of your Frameworks Components distribution
    ifeq ($(REQUIRE_FC), 1)
        TEST_FILE := $(FC_INSTALL_DIR)/packages/ti/sdo/fc/dskt2/package.xdc
        ifeq ($(wildcard $(TEST_FILE)),)
            $(error FC_INSTALL_DIR is set to "$(FC_INSTALL_DIR)", $(ERRMSG))
        endif
        XDC_PATH := $(XDC_PATH);$(FC_INSTALL_DIR)/packages
    endif

    # BIOSUTILS_INSTALL_DIR is the location of your BIOSUTILS distribution
    ifeq ($(REQUIRE_BIOS), 1)
        TEST_FILE := $(BIOSUTILS_INSTALL_DIR)/packages/ti/bios/utils/package.xdc
        ifeq ($(wildcard $(TEST_FILE)),)
            $(error BIOSUTILS_INSTALL_DIR is set to "$(BIOSUTILS_INSTALL_DIR)", $(ERRMSG))
        endif
        XDC_PATH := $(XDC_PATH);$(BIOSUTILS_INSTALL_DIR)/packages
    endif

endif

# BIOS_INSTALL_DIR is the location of your BIOS distribution
ifeq ($(REQUIRE_BIOS), 1)
    TEST_FILE := $(BIOS_INSTALL_DIR)/packages/ti/bios/package.xdc
    ifeq ($(wildcard $(TEST_FILE)),)
        $(error BIOS_INSTALL_DIR is set to "$(BIOS_INSTALL_DIR)", $(ERRMSG))
    endif
    XDC_PATH := $(XDC_PATH);$(BIOS_INSTALL_DIR)/packages
endif

# XDC_INSTALL_DIR is the location of your XDCTOOLS installation.
ifeq ($(REQUIRE_XDC), 1)
    TEST_FILE := $(XDC_INSTALL_DIR)/packages/xdc/package.xdc
    ifeq ($(wildcard $(TEST_FILE)),)
        $(error XDC_INSTALL_DIR is set to "$(XDC_INSTALL_DIR)", $(ERRMSG))
    endif
endif

# XDC_PATH is complete. Any other components you could add as
# XDC_PATH := <your component>/packages;$(XDC_PATH)
