
# Set as-need to an intermediate var...
ASNEEDED = "-Wl,--as-needed"

# ...so we can blacklist it for recipes that break with it
ASNEEDED_pn-console-tools = ""
ASNEEDED_pn-distcc = ""
ASNEEDED_pn-openobex = ""
ASNEEDED_pn-icu = ""
ASNEEDED_pn-xserver-kdrive-xomap = ""
ASNEEDED_pn-minimo = ""
ASNEEDED_pn-pciutils = ""
ASNEEDED_pn-puzzles = ""
ASNEEDED_pn-dialer = ""
ASNEEDED_pn-pulseaudio = ""
ASNEEDED_pn-python = ""
ASNEEDED_pn-libproxy = ""
ASNEEDED_pn-libxsettings-client = ""
ASNEEDED_pn-libmatchbox = ""
ASNEEDED_pn-faac = ""
ASNEEDED_pn-wireless-tools = ""
ASNEEDED_pn-ffmpeg = ""

# Append it to TARGET_LDLFLAGS 
TARGET_LDFLAGS += "${ASNEEDED}"

