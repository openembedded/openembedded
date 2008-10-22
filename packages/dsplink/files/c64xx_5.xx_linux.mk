#   ============================================================================
#   @file   c64xx_5.xx_linux.mk
#
#   @path   $(DSPLINK)/make/DspBios/
#
#   @desc   This makefile defines OS specific macros used by MAKE system for
#           the DSP/BIOS version 5.xx for C64XX on Linux.
#
#   @ver    1.50
#   ============================================================================
#   Copyright (c) Texas Instruments Incorporated 2002-2007
#
#   Use of this software is controlled by the terms and conditions found in the
#   license agreement under which this software has been supplied or provided.
#   ============================================================================


ifndef C64XX_5_XX_LINUX_MK

define C64XX_5_XX_LINUX_MK
endef


#   ============================================================================
#   Let the make system know that a specific distribution for the GPP OS
#   is being used.
#   ============================================================================
USE_DISTRIBUTION := 1


#   ============================================================================
#   Set the values of necessary variables to be used for the OS.
#   ============================================================================

#   ----------------------------------------------------------------------------
#   Base directory for the DSP OS
#   ----------------------------------------------------------------------------
BASE_INSTALL    := SEDME_TITOOLS_BASEPATH
BASE_SABIOS     := $(BASE_INSTALL)/SEDME_BIOSUNPACKDIR
BASE_BUILDOS    := $(BASE_SABIOS)/packages/ti/bios

#   ----------------------------------------------------------------------------
#   Base directory for the XDC tools
#   ----------------------------------------------------------------------------
XDCTOOLS_DIR    := $(BASE_SABIOS)/xdctools

#   ----------------------------------------------------------------------------
#   Base for code generation tools - compiler, linker, archiver etc.
#   ----------------------------------------------------------------------------
BASE_CGTOOLS    := $(BASE_INSTALL)/SEDME_CGTOOLSDIR
BASE_CGTOOLSBIN := $(BASE_CGTOOLS)/bin

#   ----------------------------------------------------------------------------
#   Base for TCONF, platform files and dependent components
#   ----------------------------------------------------------------------------
BASE_TCONF      := $(XDCTOOLS_DIR)
BASE_PLATFORMS  := $(BASE_SABIOS)/packages
BASE_CSL        := $(BASE_INSTALL)/c6000/csl
BASE_PSL        := $(BASE_SABIOS)/packages/ti/psl
BASE_RTDX       := $(BASE_SABIOS)/packages/ti/rtdx


#   ----------------------------------------------------------------------------
#   Base directory for include files
#   ----------------------------------------------------------------------------
BASE_OSINC      := $(BASE_BUILDOS)/include
BASE_CGTOOLSINC := $(BASE_CGTOOLS)/include
BASE_RTDXINC    := $(BASE_RTDX)/include/c6000
BASE_PSLINC     := $(BASE_PSL)/include
BASE_CSLINC     := $(BASE_CSL)/include

OSINC_GENERIC   := $(BASE_OSINC)
OSINC_PLATFORM  := $(BASE_CGTOOLSINC) $(BASE_CSLINC)  $(BASE_RTDXINC)  $(BASE_PSLINC)


ifeq ($(PLATFORM), morpheus_dev)
OSINC_PLATFORM  += $(BASE_INSTALL)/boards/evmdm642/include
endif # ifeq ($(PLATFORM), morpheus_dev)

ifneq ("$(VARIANT)", "")
OSINC_VARIANT   := $(BASE_OSINC)
endif


#   ----------------------------------------------------------------------------
#   Base directory for libraries
#   ----------------------------------------------------------------------------
BASE_OSLIB      := $(BASE_BUILDOS)/lib
BASE_CGTOOLSLIB := $(BASE_CGTOOLS)/lib
BASE_RTDXLIB    := $(BASE_RTDX)/lib/c6000
BASE_PSLLIB     := $(BASE_PSL)/lib
BASE_CSLLIB     := $(BASE_CSL)/lib

OSLIB_GENERIC   := $(BASE_OSLIB)
OSLIB_PLATFORM  := $(BASE_CGTOOLSLIB) $(BASE_RTDXLIB) \
                   $(BASE_PSLLIB) $(BASE_CSLLIB)

ifeq ($(PLATFORM), morpheus_dev)
OSLIB_PLATFORM  += $(BASE_INSTALL)/boards/evmdm642/lib
endif # ifeq ($(PLATFORM), morpheus_dev)

ifeq ($(PLATFORM), DM642_PCI)
OSLIB_PLATFORM  += $(BASE_INSTALL)/boards/evmdm642/lib
endif # ifeq ($(PLATFORM), DM642_PCI)

ifneq ("$(VARIANT)", "")
OSLIB_VARIANT   := $(BASE_OSLIB)
endif


#   ============================================================================
#   COMPILER
#   ============================================================================

#   ----------------------------------------------------------------------------
#   Name of the compiler
#   ----------------------------------------------------------------------------
COMPILER        := $(BASE_CGTOOLSBIN)/cl6x

#   ----------------------------------------------------------------------------
#   Command line switches used by the compiler
#
#   CC_SW_DEF       Command line defines
#   CC_SW_INC       Search path for header files
#   CC_SW_OBJ       Object file directory
#   CC_SW_DEB       Include debug information
#   CC_SW_REL       Release build
#   ----------------------------------------------------------------------------
CC_SW_DEF       := -d
CC_SW_INC       := -I
CC_SW_OBJ       := -fr
CC_SW_DEB       := -g -d"_DEBUG"
CC_SW_REL       := -o3

#   ----------------------------------------------------------------------------
#   Standard flags for the compiler
#   ----------------------------------------------------------------------------
STD_CC_FLAGS    := SEDME_DSPFLAGS 

#   ----------------------------------------------------------------------------
#   Standard flags for the compiler when building an executable
#   ----------------------------------------------------------------------------
EXE_CC_FLAGS    :=

#   ----------------------------------------------------------------------------
#   Flags for the compiler when building an archive
#   ----------------------------------------------------------------------------
ARC_CC_FLAGS    :=

#   ----------------------------------------------------------------------------
#   Standard definitions for the compiler
#   ----------------------------------------------------------------------------
STD_CC_DEFNS    :=


#   ============================================================================
#   ARCHIVER
#   ============================================================================
ARCHIVER        := $(BASE_CGTOOLSBIN)/ar6x

#   ----------------------------------------------------------------------------
#   Standard flags for the archiver
#   ----------------------------------------------------------------------------
STD_AR_FLAGS    := -r

#   ----------------------------------------------------------------------------
#   Archiver flags for extracting object files
#   ----------------------------------------------------------------------------
EXT_AR_FLAGS    := xq


#   ============================================================================
#   LINKER
#   ============================================================================
LINKER          := $(BASE_CGTOOLSBIN)/cl6x -z

#   ----------------------------------------------------------------------------
#   Command line switches used by the linker
#
#   LD_SW_INC       Search path for libraries
#   LD_SW_LIB       Include library name
#   LD_SW_OUT       Output file name
#   LD_SW_MAP       Map file name
#   LD_SW_RELOC     Generate relocateable output
#   ----------------------------------------------------------------------------
LD_SW_INC       := -i
LD_SW_LIB       := -l
LD_SW_OUT       := -o
LD_SW_MAP       := -m
LD_SW_RELOC     := -r

#   ----------------------------------------------------------------------------
#   Standard flags for the linker
#   ----------------------------------------------------------------------------
STD_LD_FLAGS    := -c  -x

#   ----------------------------------------------------------------------------
#   Flags for the linker when building an executable
#   ----------------------------------------------------------------------------
EXE_LD_FLAGS    :=

ifeq ($(PLATFORM), morpheus_dev)
EXE_LD_FLAGS    += $(LD_SW_LIB)"cslDM642.lib"
EXE_LD_FLAGS    += $(LD_SW_LIB)"morpheus.lib"
endif # ifeq ($(PLATFORM), morpheus_dev)

ifeq ($(PLATFORM), DM642_PCI)
EXE_LD_FLAGS    += $(LD_SW_LIB)"cslDM642.lib"
endif # ifeq ($(PLATFORM), DM642_PCI)

#   ============================================================================
#   TCONF
#   ============================================================================
TCONF           := $(BASE_TCONF)/tconf


#   ----------------------------------------------------------------------------
#   Standard flags for TCONF
#   ----------------------------------------------------------------------------
STD_TCF_FLAGS   :=


endif   # ifndef C64XX_5_XX_LINUX_MK
