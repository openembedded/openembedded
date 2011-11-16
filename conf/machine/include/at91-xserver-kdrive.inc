# Common description for Atmel ARM processors with LCD controller
# xserver-kdrive version

#PREFERRED_PROVIDER_virtual/xserver = "xserver-kdrive"
#PREFERRED_PROVIDER_virtual/xserver = "xserver-kdrive-1300"

PREFERRED_PROVIDER_xserver = "xserver-kdrive"
#XSERVER = "xserver-kdrive-fbdev"

# Angstrom defines:
#PREFERRED_VERSION_xserver-kdrive = "1.4.0.90"
#PREFERRED_VERSION_xserver-kdrive = "1.6.1"

include conf/machine/include/at91-lcd-noX.inc

