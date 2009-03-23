EXTRA_CFLAGS := -DBUS_PCMCIA -DWVLAN_49 -DHCF_MEM_IO -DHAS_WIRELESS_EXTENSIONS -DUSE_UIL -DUSE_WPA
EXTRA_CFLAGS += -DDBG=1 -DDBG_LVL=2

# Station:
EXTRA_CFLAGS += -DSTA_ONLY

# Access-Point:
#EXTRA_CFLAGS += -DAP_ONLY -DUSE_WDS

# Station & Access-Point:
#EXTRA_CFLAGS += -DUSE_WDS

# Je nach Station, AP oder St+Ap müssen verschiedene Firmware-Versionen einkompiliert werden:
ifneq ($(findstring STA_ONLY,$(EXTRA_CFLAGS)),)
sta_ap-objs := sta_h$(COMPILE_HERMES).o
else
ifneq ($(findstring AP_ONLY,$(EXTRA_CFLAGS)),)
sta_ap-objs := ap_h$(COMPILE_HERMES).o
else
sta_ap-objs := sta_h$(COMPILE_HERMES).o
sta-ap-objs += ap_h$(COMPILE_HERMELS).o
endif
endif


#######################################

ifeq ($(COMPILE_HERMES),1)

EXTRA_CFLAGS := $(EXTRA_CFLAGS) -DHERMES1

list-multi := wlags49_h1_cs.o

wlags49_h1_cs-objs := wl_cs.o wl_main.o wl_netdev.o wl_priv.o wl_util.o wl_wext.o \
	hcf.o mmd.o dhf.o $(sta_ap-objs)

obj-m := wlags49_h1_cs.o

wlags49_h1_cs.o: $(wlags49_h1_cs-objs)
	$(LD) $(LD_RFLAG) -r -o $@ $(wlags49_h1_cs-objs)

endif

#######################################

ifeq ($(COMPILE_HERMES),2)

EXTRA_CFLAGS := $(EXTRA_CFLAGS) -DHERMES2 -DUSE_RTS

list-multi := wlags49_h2_cs.o

wlags49_h2_cs-objs := wl_cs.o wl_main.o wl_netdev.o wl_priv.o wl_util.o wl_wext.o wl_enc.o \
	hcf.o mmd.o dhf.o $(sta_ap-objs)

obj-m := wlags49_h2_cs.o

wlags49_h2_cs.o: $(wlags49_h2_cs-objs)
	$(LD) $(LD_RFLAG) -r -o $@ $(wlags49_h2_cs-objs)

endif

#######################################

ifeq ($(COMPILE_HERMES),25)

EXTRA_CFLAGS := $(EXTRA_CFLAGS) -DHERMES25 -DUSE_RTS

list-multi := wlags49_h25_cs.o

wlags49_h25_cs-objs := wl_cs.o wl_main.o wl_netdev.o wl_priv.o wl_util.o wl_wext.o \
	hcf.o mmd.o dhf.o $(sta_ap-objs)

obj-m := wlags49_h25_cs.o

wlags49_h25_cs.o: $(wlags49_h25_cs-objs)
	$(LD) $(LD_RFLAG) -r -o $@ $(wlags49_h25_cs-objs)

endif


include $(TOPDIR)/Rules.make
