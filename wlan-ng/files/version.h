#ifndef _WLAN_VERSION_H
#define _WLAN_VERSION_H
#ifndef KERNEL_VERSION
#define KERNEL_VERSION(a,b,c) (((a) << 16) + ((b) << 8) + (c))
#endif

/* WLAN_HOSTIF (generally set on the command line, not detected) */
#define WLAN_PCMCIA                     1
#define WLAN_ISA                        2
#define WLAN_PCI                        3
#define WLAN_USB                        4
#define WLAN_PLX                        5
#define WLAN_SLAVE                      6
#define WLAN_RELEASE    "0.2.1-pre21"
#define WLAN_RELEASE_CODE 0x000201
#define WLAN_BUILD_DATE "Yesterday Night"

#endif

