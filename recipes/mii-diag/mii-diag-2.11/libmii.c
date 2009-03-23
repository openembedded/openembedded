/* libmii.c: MII diagnostic and setup library.

	Copyright 1997-2003 by Donald Becker.
	This version released under the Gnu General Public License,
	incorporated herein by reference.
	This source code may be distributed without modification using the
	existing notice.  Any modification to this source code must include a
	full notice as described in the GPL
	Contact the author for use under other terms.

	The author may be reached as becker@scyld.com, or C/O
	 Scyld Computing Corporation
	 914 Bay Ridge Road, Suite 220
	 Annapolis MD 21403

   References
	http://www.scyld.com/expert/NWay.html
	http://www.national.com/pf/DP/DP83840A.html
*/

static const char version_msg[] =
"libmii.c:v2.11 2/28/2005  Donald Becker (becker@scyld.com)\n"
" http://www.scyld.com/diag/index.html\n";

/* This library exports the following functions:
    IOADDR: A token passed to the mdio_read() function.
    PHY_ID: The MII transceiver address, passed uninterpreted to mdio_read().
*/
void show_mii_details(long ioaddr, int phy_id);
int monitor_mii(long ioaddr, int phy_id);

/* This library expects to be able to call the following functions: */
extern int mdio_read(long ioaddr, int phy_id, int mii_reg_num);

#include <unistd.h>
#include <stdio.h>
#include <time.h>
#include <sys/time.h>

#include <sys/types.h>
typedef u_int32_t u32;
typedef u_int16_t u16;
typedef u_int8_t u8;

static const char *media_names[] = {
	"10baseT", "10baseT-FD", "100baseTx", "100baseTx-FD", "100baseT4",
	"Flow-control", 0,
};

static void ns83843(long ioaddr, int phy_id);
static void qs6612(long ioaddr, int phy_id);
static void smsc83c180(long ioaddr, int phy_id);
static void tdk78q2120(long ioaddr, int phy_id);
static void davicom_dm9101(long ioaddr, int phy_id);
static void intel_i553(long ioaddr, int phy_id);
static void enablesemi(long ioaddr, int phy_id);
static void amd_pna(long ioaddr, int phy_id);
static void amd_tx(long ioaddr, int phy_id);
static void admtek(long ioaddr, int phy_id);
static void lu3x31(long ioaddr, int phy_id);
static void myson981(long ioaddr, int phy_id);
static void via_tahoe(long ioaddr, int phy_id);
static void via_vt6103(long ioaddr, int phy_id);
static void via_vt6105(long ioaddr, int phy_id);
static void intel(long ioaddr, int phy_id);

struct mii_partnum {
	const char *vendor;				/* Vendor name. */
	u16	 phy_id0;				/* Vendor ID (alternate ver. of ieee_oui[]) */
	u16	 phy_id1;				/* Vendor ID (alternate ver. of ieee_oui[]) */
	unsigned char ieee_oui[3];	/* IEEE-assigned organizationally unique ID */
	char flags;
	void (*(func))(long xcvr_if, int phy_id);/* Function to emit more info. */
} static oui_map[] = {
	{"Unknown transceiver type", 0x0000, 0x0000, {0,}, 0, NULL,},
	{"National Semiconductor 83840A", 0x2000, 0x5c01, {0,}, 0, NULL,},
	{"National Semiconductor 83843",  0x2000, 0x5c10, {0,}, 0, ns83843, },
	{"Level One LXT970", 0x7810, 0x0000, {0,}, 0, NULL, },
	{"Level One LXT971", 0x7810, 0x0001, {0,}, 0, NULL, },
	{"Level One LXT971A",0x7810, 0x0003, {0,}, 0, NULL, },
	{"Level One (unknown type)", 0, 0, {0x1e,0x04,0x00}, 0, NULL, },
	{"Davicom DM9101", 0x0181, 0xB800, {0,}, 0, davicom_dm9101, },
	{"Davicom (unknown type)", 0, 0, {0x00, 0x60, 0x6e}, 0, davicom_dm9101, },
	{"Quality Semiconductor QS6612", 0x0181, 0x4410, {0,}, 0, qs6612},
	{"Quality Semiconductor (unknown type)", 0,0, {0x00, 0x60, 0x51}, 0, NULL},
	{"SMSC 83c180", 0x0282, 0x1C51, {0}, 0, smsc83c180, },
	{"TDK Semi 78Q2120 rev. 2", 0x0300, 0xE542, {0,}, 0, tdk78q2120, },
	{"TDK Semi 78Q2120 rev. 3", 0x0300, 0xE543, {0,}, 0, tdk78q2120, },
	{"TDK Semi 78Q2120 rev. 11", 0x0300, 0xE54B, {0,}, 0, tdk78q2120, },
	{"TDK transceiver (unknown type)", 0,0, {0x00, 0xc0, 0x39}, 0, tdk78q2120},
	{"Intel (unknown type)", 0,0, {0x00, 0xf8, 0x00}, 0, intel_i553},
	{"Enable Semiconductor EL40-331", 0x0043, 0x7411, {0,}, 0, enablesemi},
	{"AMD 79c901A.1 HomePNA", 0x0000, 0x6B91, {0,}, 0, amd_pna},
	{"AMD 79c901A.2 HomePNA", 0x0000, 0x6B92, {0,}, 0, amd_pna},
	{"AMD 79c901A.3 HomePNA", 0x0000, 0x6B93, {0,}, 0, amd_pna},
	{"AMD 79c901A.3 10baseT", 0x0000, 0x6B71, {0,}, 0, amd_tx},
	{"AdHoc Technology AH101LF", 0x0022, 0x561B, {0,}, 0, tdk78q2120},
	{"Altimata Communications AC101LF", 0x0022, 0x5523, {0,}, 0, tdk78q2120},
	{"Altimata Comm (unknown type)", 0, 0, {0x00,0x10,0xA9}, 0, tdk78q2120},
	{"ASIX (unknown type)", 0, 0, {0x00,0xC0,0xB4}, 0, tdk78q2120},
	{"ADMtek AN983 Comet", 0x0022, 0x5410, {0,}, 0, admtek},
	{"ADMtek AN985 Comet", 0x0022, 0x5513, {0,}, 0, admtek},
	{"ADMtek (unknown type)", 0, 0, {0x00,0xe0,0x92}, 0, admtek},
	{"Lucent LU6612", 0x0180, 0x7641, {0,}, 0, qs6612},
	{"Lucent LU3X31", 0x0043, 0x7411, {0,}, 0, lu3x31},
	{"LSI Logic (Seeq) 80225", 0, 0, {0x00,0xA0,0x7D}, 0, NULL},
	{"Myson MTD981", 0x0302, 0xD000, {0,}, 0, myson981},
	{"Myson (unknown type)", 0, 0, {0x00,0xC0,0xB4,}, 0, myson981},
	{"Alta/Kendin Sundance", 0x0022, 0x1720, {0,}, 0, NULL},
	{"Alta/Kendin Sundance", 0, 0, {0x00,0x08,0x85}, 0, NULL},
	{"VIA Tahoe VT6103", 0x0101, 0x8f20, {0,}, 0, via_vt6103},
	{"VIA Tahoe VT6104", 0x0101, 0x8f30, {0,}, 0, via_tahoe},
	{"VIA Rhine VT6105", 0x0101, 0x8f22, {0,}, 0, via_vt6105},
	{"Intel 82557 series", 0x02a8, 0x0150, {0,}, 0, intel},
	{"Intel 82555 rev 1", 0x02a8, 0x0151, {0,}, 0, intel},
	{"Intel 82559 transceiver", 0x02a8, 0x0154, {0,}, 0, intel},
	{"Intel 82555 series transceiver", 0,0, {0x00,0xaa,0x00}, 0, intel},
	{0, },
};

static u16 mii_val[32];

void show_mii_details(long ioaddr, int phy_id)
{
	int mii_reg, i, vendor = 0;
	u16 bmcr, bmsr, new_bmsr;

	/* This may not be omitted from the output. */
	printf("%s", version_msg);
	printf(" MII PHY #%d transceiver registers:", phy_id);
	for (mii_reg = 0; mii_reg < 32; mii_reg++) {
		mii_val[mii_reg] = mdio_read(ioaddr, phy_id, mii_reg);
		printf("%s %4.4x", (mii_reg % 8) == 0 ? "\n  " : "",
			   mii_val[mii_reg]);
	}
	printf(".\n");
	if (mii_val[0] == 0xffff) {
		printf("  No MII transceiver present!.\n");
		return;
	}
	bmcr = mii_val[0];
	bmsr = mii_val[1];
	printf(" Basic mode control register 0x%4.4x:", bmcr);
	if (bmcr & 0x1000)
		printf(" Auto-negotiation enabled.\n");
	else
		printf(" Auto-negotiation disabled!\n"
			   "   Speed fixed at 10%s mbps, %s-duplex.\n",
			   bmcr & 0x2000 ? "0" : "",
			   bmcr & 0x0100 ? "full":"half");
	if (bmcr & 0x8000)
		printf("  Transceiver currently being reset!\n");
	if (bmcr & 0x4000)
		printf("  Transceiver in loopback mode!\n");
	if (bmcr & 0x0800)
		printf("  Transceiver powered down!\n");
	if (bmcr & 0x0400)
		printf("  Transceiver isolated from the MII!\n");
	if (bmcr & 0x0200)
		printf("  Restarted auto-negotiation in progress!\n");
	if (bmcr & 0x0080)
		printf("  Internal Collision-Test enabled!\n");
	
	new_bmsr = mdio_read(ioaddr, phy_id, 1);
	printf(" Basic mode status register 0x%4.4x ... %4.4x.\n"
		   "   Link status: %sestablished.\n"
		   "   Capable of ",
		   bmsr, new_bmsr,
		   bmsr & 0x0004 ? "" :
		    (new_bmsr & 0x0004) ? "previously broken, but now re" : "not ");
	if (bmsr & 0xF800) {
		for (i = 15; i >= 11; i--)
			if (bmsr & (1<<i))
				printf(" %s", media_names[i-11]);
	} else
		printf("<Warning! No media capabilities>");

	printf(".\n"
		   "   %s to perform Auto-negotiation, negotiation %scomplete.\n",
		   bmsr & 0x0008 ? "Able" : "Unable",
		   bmsr & 0x0020 ? "" : "not ");

	if (bmsr & 0x0010)
		printf(" Remote fault detected!\n");
	if (bmsr & 0x0002)
		printf("   *** Link Jabber! ***\n");

	if (mii_val[2] ^ mii_val[3]) { 		/* Eliminate 0x0000 and 0xffff IDs. */
		unsigned char oui_0 = mii_val[2] >> 10;
		unsigned char oui_1 = mii_val[2] >> 2;
		unsigned char oui_2 = (mii_val[2] << 6) | (mii_val[3] >> 10);

		printf(" Vendor ID is %2.2x:%2.2x:%2.2x:--:--:--, model %d rev. %d.\n",
			   oui_0, oui_1, oui_2,
			   ((mii_val[3] >> 4) & 0x3f), mii_val[3] & 0x0f);
		for ( i = 0; oui_map[i].vendor; i++)
			/* We match either the Phy ID or the IEEE OUI. */
			if ((oui_map[i].phy_id0 == mii_val[2] &&
				 oui_map[i].phy_id1 == mii_val[3]) ||
				(oui_map[i].ieee_oui[0] == oui_0 &&
				 oui_map[i].ieee_oui[1] == oui_1 &&
				 oui_map[i].ieee_oui[2] == oui_2)) {
				printf("   Vendor/Part: %s.\n", oui_map[i].vendor);
				vendor = i;
				break;
			}
		if (oui_map[i].vendor == NULL)
			printf("   No specific information is known about this transceiver"
				   " type.\n");
	} else
		printf(" This transceiver has no vendor identification.\n");

	{
		int nway_advert = mii_val[4];
		int lkpar = mii_val[5];
		printf(" I'm advertising %4.4x:", nway_advert);
		for (i = 10; i >= 5; i--)
			if (nway_advert & (1<<i))
				printf(" %s", media_names[i-5]);
		printf("\n   Advertising %sadditional info pages.\n",
			   nway_advert & 0x8000 ? "" : "no ");
		if ((nway_advert & 31) == 1)
			printf("   IEEE 802.3 CSMA/CD protocol.\n");
		else
			printf("   Using an unknown (non 802.3) encapsulation.\n");
		printf(" Link partner capability is %4.4x:",
			   lkpar);
		for (i = 10; i >= 5; i--)
			if (lkpar & (1<<i))
				printf(" %s", media_names[i-5]);
		printf(".\n   Negotiation %s.\n",
			   lkpar & 0x4000 ? " completed" : "did not complete");
	}
	if (oui_map[vendor].func)
		oui_map[vendor].func(ioaddr, phy_id);

}

int monitor_mii(long ioaddr, int phy_id)
{
	int i, last_event = 0;
	unsigned short new_1, baseline_1 = mdio_read(ioaddr, phy_id, 1);
	struct timeval tv, sleepval;
	time_t cur_time;
	char timebuf[12];

	if (baseline_1 == 0xffff) {
		fprintf(stderr, "No MII transceiver present to monitor.\n");
		return -1;
	}

	gettimeofday(&tv, NULL);
	cur_time = tv.tv_sec;
	strftime(timebuf, sizeof(timebuf), "%H:%M:%S", localtime(&cur_time));

	printf("Monitoring the MII transceiver status.\n"
		   "%s.%03d  Baseline value of MII BMSR (basic mode status register)"
		   " is %4.4x.\n", timebuf, (int)tv.tv_usec/1000, baseline_1);
	while (1) {
		new_1 = mdio_read(ioaddr, phy_id, 1);
		if (new_1 == 0xffff) {
			fprintf(stderr, "The MII transceiver is no longer accessable!\n");
			return -1;
		}
		if (new_1 != baseline_1) {
			gettimeofday(&tv, NULL);
			cur_time = tv.tv_sec;
			strftime(timebuf, sizeof(timebuf), "%H:%M:%S",
					 localtime(&cur_time));
			printf("%s.%03d  MII BMSR now %4.4x: %4s link, NWay %s, "
				   "%3sJabber%s (%4.4x).\n",
				   timebuf, (int)tv.tv_usec/1000, new_1,
				   new_1 & 0x04 ? "Good" : "no",
				   new_1 & 0x20 ? "done" : "busy",
				   new_1 & 0x02 ? "" : "No ",
				   new_1 & 0x10 ? ", remote fault" : "",
				   mdio_read(ioaddr, phy_id, 5)
				   );
			if (!(baseline_1 & 0x20)  && (new_1 & 0x20)) {
				int lkpar = mdio_read(ioaddr, phy_id, 5);
				printf("   New link partner capability is %4.4x %4.4x:",
					   lkpar, mdio_read(ioaddr, phy_id, 6));
				switch (lkpar) {
				case 0x45e1: printf(" 10/100 switch w/ flow control"); break;
				case 0x41e1: printf(" 10/100 HD+FD switch"); break;
				case 0x40a1: printf(" 10/100 bridged repeater"); break;
				case 0x4081: printf(" 100baseTx repeater w/autonegotation");
					break;
				case 0x0081: printf(" 100baseTx (no autonegotation)"); break;
				case 0x4021: printf(" 10baseT repeater w/autonegotation");
					break;
				case 0x0021: printf(" 10baseT (no autonegotation)"); break;
				default:
					for (i = 9; i >= 5; i--)
						if (lkpar & (1<<i))
							printf(" %s", media_names[i-5]);
				}
				printf(".\n");
			}
			fflush(stdout);
			baseline_1 = new_1;
			last_event = 0;
		}
		sleepval.tv_sec = 0;
		sleepval.tv_usec = last_event++ > 30 ? 200000 : 1000;
		select(0, 0, 0, 0, &sleepval);			/* Or just sleep(1); */
	}
	printf("  Value of MII BMSR (basic mode status register) is %4.4x.\n",
		   mdio_read(ioaddr, phy_id, 1));
	return 0;
}

/* Emit transceiver-specific info. */

struct msg_tbl { int bitmask;  char *msg; };

static void msg_if_set(const int val, const struct msg_tbl msg_tbl[])
{
	int i;
	for (i = 0; msg_tbl[i].bitmask; i++)
		if (msg_tbl[i].bitmask & val)
			printf(" %s\n", msg_tbl[i].msg);
}

static void msg_if_set_fmt(const int val, const struct msg_tbl msg_tbl[],
						   const char *fmt)
{
	int i;
	for (i = 0; msg_tbl[i].bitmask; i++)
		if (msg_tbl[i].bitmask & val)
			printf(fmt, msg_tbl[i].msg);
}

static void qs6612(long ioaddr, int phy_id)
{
	printf("  QS6612 extra registers: Mode %4.4x.\n"
		   "    Interrupt source %4.4x, mask %4.4x.\n"
		   "    PHY control %4.4x.\n",
		   mii_val[17], mii_val[29], mii_val[30], mii_val[31]);
	return;
}

static void ns83843(long ioaddr, int phy_id)
{
	printf("  NatSemi 83843 extra registers:\n"
		   "    PHY status %4.4x\n"
		   "    %s link, %d Mb/sec %s duplex\n"
		   "    MII interrupts %sabled, %s pending.\n"
		   "    Events since last read\n"
		   "     Link disconnects %d\n"
		   "     False carriers %d\n"
		   "     Receive errors %d\n"
		   "    Link beat is currently %sstable\n",
		   mii_val[0x10],
		   mii_val[10] & 0x0001 ? "Valid" : "Invalid",
		   mii_val[10] & 0x0002 ? 10 : 100, 
		   mii_val[10] & 0x0004 ? "full" : "half", 
		   mii_val[0x11] & 0x0002 ? "en":"dis",
		   mii_val[0x10] & 0x0100 ? "interrupt": "none",
		   mii_val[0x13], mii_val[0x14], mii_val[0x15],
		   mii_val[0x16] & 0x0010 ? "UN" : "");
	return;
}
static void smsc83c180(long ioaddr, int phy_id)
{
	int mii_reg25 = mii_val[25];
	printf("  SMSC 83c180 extra registers:\n"
		   "    Auto-negotiation status 0x%4.4x.\n"
		   "      10baseT polarity is %s.\n"
		   "      PHY address is %d.\n"
		   "      Auto-negotiation %scomplete, 1%s0Mbps %s duplex.\n"
		   "    Rx symbol errors since last read %d.\n",
		   mii_reg25,
		   mii_reg25 & 0x2000 ? "normal" : "reversed",
		   (mii_reg25>>8) & 0x1F,
		   mii_reg25 & 0x0080 ? "did not " : "",
		   mii_reg25 & 0x0020 ? "0" : "",
		   mii_reg25 & 0x0040 ? "full" : "half",
		   mdio_read(ioaddr, phy_id, 26));
	return;
}

static const char *tdk_events[8] = {
	"Jabber", "Rx error", "Negotiation page received", "Link detection fault",
	"Link partner acknowledge", "Link status change", "Remote partner fault",
	"Auto-Negotiation complete"};

static const struct msg_tbl tdk_reg16[] = {
	{0x8000, " Transceiver is in repeater mode!"},
	{0x4000, " Interrupt pin set to active high."},
	{0x2000, " Reserved bit 12 is unexpectedly set."},
	{0x1000, " Transmit pins are internally disconnected."},
	{0x0800, " 10baseT signal quality test is disabled."},
	{0x0400, " 10baseT loopback mode."},
	{0, 0},
};

static void tdk78q2120(long ioaddr, int phy_id)
{
	int mii_reg16 = mii_val[16];
	int mii_reg17 = mii_val[17];
	int mii_reg18 = mii_val[18];
	int i;
	printf("  TDK format vendor-specific registers 16..18 are "
		   "0x%4.4x 0x%4.4x 0x%4.4x\n", mii_reg16, mii_reg17, mii_reg18);
	printf("      Link polarity is %s %s.\n"
		   "%s%s"
		   "      Auto-negotiation %s, 1%s0Mbps %s duplex.\n"
		   "      Rx link in %s state, PLL %s.\n",
		   mii_reg16 & 0x0020 ? "OVERRIDDEN to" : "detected as",
		   mii_reg16 & 0x0010 ? "reversed" : "normal",
		   mii_reg16 & 0x0002 ?
		   "     100baseTx Coding and scrambling is disabled!\n":"",
		   mii_reg16 & 0x0001 ? "     Rx_CLK power-save mode is enabled!\n":"",
		   mii_reg18 & 0x1000 ? "had no common media" : "complete",
		   mii_reg18 & 0x0400 ? "0" : "",
		   mii_reg18 & 0x0800 ? "full" : "half",
		   mii_reg18 & 0x0200 ? "pass" : "fail",
		   mii_reg18 & 0x0100 ? "slipped since last read" : "locked");

	msg_if_set(mii_reg16, tdk_reg16);
	if (mii_reg17 & 0x00ff) {
		printf("      Events since last read:");
		for (i = 0; i < 8; i++)
			if (mii_reg17 & (1 << i))
				printf("  %s", tdk_events[i]);
	} else
		printf("      No new link status events.");

	if (mii_reg17 & 0xff00) {
		printf("\n      Events that will raise an interrupt:");
		for (i = 0; i < 8; i++)
			if (mii_reg17 & (0x100 << i))
				printf("  %s", tdk_events[i]);
	}
	printf("\n");
	return;
}

static void davicom_dm9101(long ioaddr, int phy_id)
{
	printf("  Davicom vendor specific registers: 0x%4.4x 0x%4.4x 0x%4.4x.\n",
		   mii_val[16], mii_val[17], mii_val[18]);
}
static void intel_i553(long ioaddr, int phy_id)
{
	printf("  This transceiver is 100baseT4 only!  Register 16 is %4.4x.\n",
		   mii_val[16]);
}
/* http://www.enablesemi.com/cgi-bin/byteserve/Products/Docs/3VCardBus.pdf */
static void enablesemi(long ioaddr, int phy_id)
{
	printf("  Isolated %d times, %d false carrier events, %d Rx errors.\n",
		   mii_val[18], mii_val[19], mii_val[21]);
	printf("  Cable polarity is %s, 100Mb PLL is %slocked.\n",
		   mii_val[28]&0x8000 ? "reversed" : "normal",
		   mii_val[27]&0x2000 ? "" : "un");
}
/* The amd79c901 contains both PNA and 10/100 management registers.
   http://www.amd.com/products/npd/techdocs/22304.pdf
*/
static void amd_pna(long ioaddr, int phy_id)
{
	printf("  HomePNA transceiver in %s speed, %s power mode.\n",
		   mii_val[16] & 4 ? "high" : "low",
		   mii_val[16] & 2 ? "high" : "low");
	printf("  HomePNA noise level %d, peak power %d..\n",
		   mii_val[25] >> 8, mii_val[25] & 0xff);
}
static void amd_tx(long ioaddr, int phy_id)
{
	int mii_reg25 = mii_val[25];
	printf("  AMD vendor specific registers: 0x%4.4x 0x%4.4x 0x%4.4x.\n",
		   mii_val[16], mii_val[17], mii_val[18]);
	printf("  The link is %s in 10%s %s duplex mode, autonegotiation state "
		   "has%s changed.\n",
		   mii_reg25 & 8 ? "up" : "down",
		   mii_reg25 & 1 ? "0baseTx" : "baseT",
		   mii_reg25 & 4 ? "full" : "half",
		   mii_reg25 & 2 ? "" : " not");
}

static const struct msg_tbl admtek_reg21[] = {
	{0x4000, " Link test diabled: Ignoring lack of 10baseT link beat."},
	{0x2000, " Link forced up."},
	{0x1000, " Tx jabber check disabled."},
	{0x0080, " Transmitting 'Far End Fault'!"},
	{0x0040, " Rx error count full."},
	{0x0008, " Remote loop back enabled."},
	{0, 0},
};

static void admtek(long ioaddr, int phy_id)
{

	printf("  ADMtek vendor specific registers information:\n"
		   "   Cable length is approximately %d meters.\n"
		   "   The receiver has lost lock %d times since last check and "
		   "had %d error events.\n",
		   ((mii_val[20] & 0x00f0) >> 4)*10,
		   mii_val[23], mii_val[23]);
	msg_if_set(mii_val[21], admtek_reg21);
	tdk78q2120(ioaddr, phy_id);
}

static void lu3x31(long ioaddr, int phy_id)
{
	printf("  Lucent vendor specific registers 17: 0x%4.4x"
		   " 29: 0x%4.4x 30: 0x%4.4x 31: 0x%4.4x.\n",
		   mii_val[17], mii_val[29], mii_val[30], mii_val[31]);
}

static const struct msg_tbl myson_reg16[] = {
	{0x0080, " Far end fault enabled."},
	{0x0040, " Transformer ratio 1.25:1."},
	{0x0020, " Polarity correction diabled."},
	{0x0010, " Link is forced up regardless of link beat."},
	{0x0004, " Bypass Jabber check."},
	{0x0001, " 100baseFx mode selected."},
	{0, 0},
};

static void myson981(long ioaddr, int phy_id)
{
	int i, mii_reg17 = mii_val[17];

	printf("  Myson mtd981 extra registers: %4.4x %4.4x %4.4x %4.4x.\n",
		   mii_val[16], mii_val[17], mii_val[18], mii_val[19]);
	msg_if_set(mii_val[16] & 0xC800, tdk_reg16);
	msg_if_set(mii_val[16], myson_reg16);

	if (mii_reg17 & 0x00ff) {
		printf("      Events since last read:");
		for (i = 0; i < 8; i++)
			if (mii_reg17 & (1 << i))
				printf("  %s", tdk_events[i]);
	} else
		printf("      No new link status events.");
	if (mii_reg17 & 0xff00) {
		printf("\n      Events that will raise an interrupt:");
		for (i = 0; i < 8; i++)
			if (mii_reg17 & (0x100 << i))
				printf("  %s", tdk_events[i]);
	}
	printf("\n");

	return;
}

/* These are much like the TDK events in reversed order. */
static const struct msg_tbl via_reg17[] = {
	{0x0001, "Auto-Negotiation complete"},
	{0x0002, "Remote fault detected"},
	{0x0004, "Link failure detected"},
	{0x0008, "Bad Start Stream detected"},
	{0x0010, "Parallel detection fault"},
	{0x0020, "Extended negotiation page received"},
	{0x0040, "5B/4B code error detected"},
	{0x0080, "Jabber detected"},
	{0, 0},
};

static void via_tahoe(long ioaddr, int phy_id)
{
	int mii_reg16 = mii_val[16];
	int mii_reg17 = mii_val[17];
	int mii_reg18 = mii_val[18];

	printf("  VIA Tahoe extended registers: 16 %4.4x  #17 %4.4x  #18 %4.4x.\n",
		   mii_reg16, mii_reg17, mii_reg18);
	msg_if_set_fmt(mii_reg17, via_reg17, "   %s\n");
	printf("   Link %s 10%s Mbps %s duplex\n",
		   mii_reg18 & 0x2000 ? "up" : "down",
		   mii_reg18 & 0x0400 ? "0" : "",
		   mii_reg18 & 0x0800 ? "full" : "half");
}

/* Information from
   http://www.via.com.tw/en/datasheet/DS6103110.pdf
*/
   
static void via_vt6103(long ioaddr, int phy_id)
{
	printf("  VIA vt6103 error counts since the last check:\n"
		   "   The link has failed %d times.\n"
		   "   The receiver has lost lock %d times.\n"
		   "   There have been %d false carrier/SQE error.\n",
		   mii_val[21], mii_val[22], mii_val[23]);
}

/* Information from
   http://www.via.com.tw/en/Networking/DS6105LOM100.pdf
*/

static void via_vt6105(long ioaddr, int phy_id)
{
	printf("  VIA vt6105 PHY status:\n"
		   "   Duplex %s  speed %s\n",
		   mii_val[20] & 0x0001 ? "full" : "half",
		   mii_val[20] & 0x0002 ? "100" : "10");
}

/* Information from
   http://www.via.com.tw/en/Networking/DS6105LOM100.pdf
*/
static void intel(long ioaddr, int phy_id)
{
	printf("  Intel 8255* PHY #%d extended management registers:\n"
		   "    Error counts, cleared when read:\n"
		   "     False carriers %d\n"
		   "     Link disconnects %d\n"
		   "     Receive errors %d\n"
		   "     Rx symbol errors %d.\n"
		   "     Rx 10Mbps Early End-Of-Frame errors %d.\n"
		   "     Rx 100Mbps Early End-Of-Frame errors %d.\n"
		   "     Tx jabber errors %d.\n",
		   mii_val[18],
		   mii_val[19], mii_val[20], mii_val[21], mii_val[22], mii_val[23],
		   mii_val[24], mii_val[25]);
}


/*
 * Local variables:
 *  compile-command: "cc -O -Wall -c libmii.c"
 *  c-indent-level: 4
 *  c-basic-offset: 4
 *  tab-width: 4
 * End:
 */
