DESCRIPTION = "Task packages for the Angstrom distribution"
PR = "r32"

inherit task

RDEPENDS_${PN} = "\
    nmap \
    ettercap \
    stunnel \
    curl \
#    dsniff \
    prismstumbler \
#    tcpdump \
    kismet \
    hydra \
#    thcrut \
#    driftnet \
    miniclipboard"
