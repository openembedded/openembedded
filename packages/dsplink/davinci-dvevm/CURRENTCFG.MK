#   =========================================================
#   DSP/BIOS LINK Configuration file.
#
#   CAUTION! This is a generated file.
#            All changes will be lost.
#
#   This file was generated on MAY 14, 2008  11:53:09
#   =========================================================


#   =========================================================
#   When this file was created.
#   =========================================================
export  CFGDATE            := MAY 14, 2008  11:53:09


#   =========================================================
#   DSP/BIOS LINK GPP side root directory.
#   =========================================================
export GPPROOT             := /home/balister/src/dsplink_1_50/dsplink/gpp
export DSPROOT             := /home/balister/src/dsplink_1_50/dsplink/dsp


#   =========================================================
#   GPP and DSP OS for which DSP/BIOS LINK is being built
#   =========================================================
export GPPOS               := Linux
export DSPOS               := DspBios


#   =========================================================
#   Specific distribution of GPP and DSP OS (if any)
#   =========================================================
export GPPDISTRIBUTION     := davinci_mvlpro5.0
export GPPOSVERSION        := 2.6.18
export GPPOSVARIANT        := 
export DSPDISTRIBUTION     := c64xxp_5.xx_linux


#   =========================================================
#   Target GPP and DSP platforms for DSP/BIOS LINK
#   =========================================================
export GPPPLATFORM         := Davinci
export DSPPLATFORM         := Davinci


#   =========================================================
#   Target GPP and DSP devices
#   =========================================================
export GPPDEVICE           := Davinci
export DSPDEVICE           := C64XX


#   =========================================================
#   Compile time scalability options for DSP/BIOS LINK
#   =========================================================
export USE_PROC            := 1
export USE_POOL            := 1
export USE_NOTIFY          := 1
export USE_MPCS            := 1
export USE_RINGIO          := 1
export USE_MPLIST          := 0
export USE_MSGQ            := 0
export USE_CHNL            := 0


#   =========================================================
#   Compile time physical link scalability options for device
#   =========================================================
export USE_CHNL_ZCPY_LINK  := 0
export USE_CHNL_PCPY_LINK  := 0
export USE_MSGQ_ZCPY_LINK  := 0
export USE_MSGQ_PCPY_LINK  := 0


#   =========================================================
#   Enable/ Disable trace
#   =========================================================
export TRACE               := 1


#   =========================================================
#   Enable/ Disable profiling
#   =========================================================
export PROFILE             := 1


#   =========================================================
#   Enable/ Disable probe
#   =========================================================
export PROBE               := 0


#   =========================================================
#   Platform Variant
#   =========================================================
export VARIANT             := DM6446


