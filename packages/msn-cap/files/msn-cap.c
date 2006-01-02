/*    MSN CAPTURE is a software which capture packets of msn protocol and show to user in             */
/*    a good format to see the important things in networks with hubs or switched (arpspoof).         */
/*    This program use libpcap.                                                                       */
/*   HOW TO USE:                                                                                      */
/*   YOU MUST BE ROOT !!!!                                                                            */
/*   root@slack:/home/gabriel/pcap# gcc msn-cap.c -o msn-cap -lpcap                                   */              
/*   root@slack:/home/gabriel/pcap# msn-cap -n billgates@msn.com                                      */
/*   -------------------------------------------------------------------------------------            */
/*   billgates@msn.com <10.6.6.6> talk to steve_ballmer@hotmail.com <10.6.6.24> and says:             */
/*   how do you want destroy gpl???                                                                   */
/*  ---------------------------------------------------------------------------------------           */
/*   -------------------------------------------------------------------------------------            */
/*   steve_ballmer@hotmail.com <10.6.6.24> talk to billgates@msn.com <10.6.6.6> and says:             */
/*   a pact with devil is very good!!!                                                                */ 
/*  ---------------------------------------------------------------------------------------           */
/*   -------------------------------------------------------------------------------------            */
/*   billgates@msn.com <10.6.6.6> talk to steve_ballmer@hotmail.com <10.6.6.24> and says:             */
/*   but i already sold my soul to him...                                                             */
/*  ---------------------------------------------------------------------------------------           */
/*   -------------------------------------------------------------------------------------            */
/*   steve_ballmer@hotmail.com <10.6.6.24> talk to billgates@msn.com <10.6.6.6> and says:             */
/*   shit...                                                                                          */ 
/*  ---------------------------------------------------------------------------------------           */
/*                                                                                                    */
/*   You need to get a few of packets to take some nicks, because this program works with lists and   */
/*   take it when a packet of type "TypingUser" comes and it associates the nick with the IP to form  */
/*   the structures. It is very fast!!!! In case appear a "Unknown User" in the place of original user*/
/*   , is question of time to get the real user. MUCH LITTLE TIME !!!                                 */
/*                                                                                                    */
/*  Tested on Linux SlackWare 10.1 - 2.6.13                                                           */
/*                                                                                                    */
/*                                                                                                    */
/*                                                                                                    */
/*  More about the use of program is below...                                                         */
/*                                                                                                    */
/* Valew EccJr e a galera do SoftwareUpdateOnTheFuckers...                                            */
/*  Created by Gabriel Menezes Nunes < dragao_branco >                                                */
/*                                    UNESP -- IBILCE                                                 */
/*                                                                                                    */

	
													
	
	
#define __USE_BSD
#include <stdio.h>
#include <pcap.h>
#define __FAVOR_BSD
#include <netinet/tcp.h>
#include <netinet/ip.h>
#include <netinet/ip.h>
#include <netinet/udp.h>
#include <netinet/if_ether.h>
#include <unistd.h>
	
	
	
struct user {
  char ip[16];
  char nick[200];
  struct user *prox;
} *l;
char nick1[200], nick2[200], filename[200];
int exclusive = 0, activate = 0;
FILE *fd;

char *get_my_nick(struct user *l, char *ip);
void callfunc (u_char *args, const struct pcap_pkthdr *header, const u_char *packet);
void print_msg(char *msg, char *nick_src, char *nick_dst, char *ip_src, char *ip_dst);
void get_msg(u_char *payload, char *msg, int cont);
void get_nick(u_char *payload, char *nick);
struct user *insert(struct user *l, char *nick, char *ip);
	
void callfunc (u_char *args, const struct pcap_pkthdr *header, const u_char *packet){
  struct ether_header *ethernet;
  struct ip *ip;
  struct tcphdr *tcp;
  struct udphdr *udp;
  int i = 0, k = 0, s1, len;
  char ascii[1024], nick[200], ip_dst[16], ip_src[16], teste[200], nick_src[200], nick_dst[200], *asc;
  char *payload, buffer[100], type[100], msg[200];
  ethernet = (struct ether_header*)(packet);
  ip       = (struct ip*)(packet + sizeof(struct ether_header));
  tcp   = (struct tcphdr*)(packet + sizeof(struct ether_header) + sizeof(struct ip));
  payload = (char *)(packet + sizeof(struct ether_header) + sizeof(struct ip) + sizeof(struct tcphdr));
  len = (ntohs(ip->ip_len)) - 40;
  asc = ascii;
  while(--len >= 0 && k++ < 1022){
    s1 = *payload++;
    if(s1 == '\r'){
      *asc++ = '\r';
      continue;
    }
    *(asc++) = (isgraph(s1) ? s1 : ' ');
  }
   *asc = '\0';
  if((strstr(ascii, "msmsgscontrol"))){
    get_nick(ascii, nick);
    strcpy(ip_src, (char*)inet_ntoa(ip->ip_src));
    l = insert(l, nick, ip_src);
  }

  if((strstr(ascii, "plain")) && strstr(ascii, "MSG")) {

    get_msg(ascii, msg, 5);
    strcpy(ip_src, (char*)inet_ntoa(ip->ip_src));
    strcpy(ip_dst, (char*)inet_ntoa(ip->ip_dst));
    strncpy(nick_src, get_my_nick(l, ip_src), 199);
    strncpy(nick_dst, get_my_nick(l, ip_dst), 199);
    if(activate)
      print_msg(msg, nick_src, nick_dst, ip_src, ip_dst);
    if((!nick1[0]) && (!nick2[0]))
      print_msg(msg, nick_src, nick_dst, ip_src, ip_dst);
    if((nick1[0]) && (nick2[0])){
      if(!exclusive){
	if((!(strcmp(nick_src, nick1))) || (!(strcmp(nick_src, nick2))) || (!(strcmp(nick_dst, nick2))) || (!(strcmp(nick_dst, nick1))))
	  print_msg(msg, nick_src, nick_dst, ip_src, ip_dst);
      }
      if(exclusive){
	if(((!(strcmp(nick_src, nick1))) && (!(strcmp(nick_dst, nick2)))) || ((!(strcmp(nick_src, nick2))) && (!(strcmp(nick_dst, nick1)))) )
	  print_msg(msg, nick_src, nick_dst, ip_src, ip_dst);
      }
    }
    if((nick1[0]) && (!nick2[0])){
      if((!(strcmp(nick_src, nick1))) || (!(strcmp(nick_dst, nick1))))
	print_msg(msg, nick_src, nick_dst, ip_src, ip_dst);
    }
    if((!nick1[0]) && (nick2[0])){
      if((!(strcmp(nick_src, nick2))) || (!(strcmp(nick_dst, nick2))))
	print_msg(msg, nick_src, nick_dst, ip_src, ip_dst);
    }
  }
}
main(int argc, char **argv){
  char *dev, errbuf[PCAP_ERRBUF_SIZE] , ip1[200], ip2[200], buffer[200], filter_app[200] = "(port 1863)";
  pcap_t *man;
  struct bpf_program filter;
  unsigned char packet[65535];
  bpf_u_int32 mask,  net;
  int control;
  memset(nick1, '\0', sizeof(nick1));
  memset(nick2, '\0', sizeof(nick2));
  memset(ip1, '\0', sizeof(ip1));
  memset(ip2, '\0', sizeof(ip2));
  memset(filename, '\0', sizeof(filename));
  if(argc < 2){
    printf("---------------------------------------------------------------------------------------------\n");
    printf("\t\t\tMSN CAPTURE by < dragao_branco >\n\n");
    printf("You MUST be ROOT\n");
    printf("%s -a [0 or 1] -n [nick1] -m [nick2] -i [IP1] -y [IP2] -x [0 or 1] -f [filename]\n\n", argv[0]);
    printf("-a --> ALL PACKETS!!!\n");
    printf("-x --> eXclusive\n");
    printf("-f --> filename to log the packets\n");
    printf("Choose 0 or 1 to activate or not the capture of ALL packets and the eXclusive mode\n");
    printf("You can choose one or two nicks to capture\n");
    printf("The same thing can be done with IPS\n");
    printf("Whether you choose the '-x' option, just the IPs or nicks (or both) will be capture\n");
    printf("Or you capture everything in your lan!!!\n");
    printf("Ex: %s -n smallville@hotmail.com\n", argv[0]);
    printf("You will capture packets from/to this nick\n");
    printf("Ex: %s -n smallville@hotmail.com -m lex_luthor@msn.com\n", argv[0]);
    printf("Will capture packets from/to this nicks\n");
    printf("Ex: %s -n smallville@hotmail.com -m lex_luthor@msn.com -x 1\n", argv[0]);
    printf("Will capture packets ONLY between this nicks\n");
    printf("The same thing can be done with IPs\n");
    printf("---------------------------------------------------------------------------------------------\n");
    exit(-1);
  }
  while ((control = getopt(argc, argv, "n:m:i:y:x:a:f:")) != -1){
    switch(control){
    case 'n': strncpy(nick1, optarg, 199);
      break;
    case 'm': strncpy(nick2, optarg, 199);
      break;
    case 'i': strncpy(ip1, optarg, 199);
      break;
    case 'y': strncpy(ip2, optarg, 199);
      break;
    case 'x': exclusive = atoi(optarg);
      break;
    case 'a': activate = atoi(optarg);
      break;
    case 'f': strncpy(filename, optarg, 199);
              fd = fopen(filename, "w");
      break;
    }
  }
  if(activate){
    memset(nick1, '\0', sizeof(nick1));
    memset(nick2, '\0', sizeof(nick2));
    memset(ip1, '\0', sizeof(ip1));
    memset(ip2, '\0', sizeof(ip2));
  }
  if(ip1[0] != '\0' && ip2[0] != '\0'){
    if(!exclusive)
      sprintf(buffer, " and (host %s or host %s)", ip1, ip2);
    else
      sprintf(buffer, " and (host %s and host %s)", ip1, ip2);
    strncat(filter_app, buffer, strlen(buffer));
  }
  if(ip1[0] == '\0' && ip2[0] != '\0'){
    sprintf(buffer, " and host %s", ip2);
    strncat(filter_app, buffer, strlen(buffer));
  }
  if(ip1[0] != '\0' && ip2[0] == '\0'){
    sprintf(buffer, " and host %s", ip1);
    strncat(filter_app, buffer, strlen(buffer));
  }
  printf("Using the rule: %s\n", filter_app);
  if(filename[0])
  printf("Save data in %s\n", filename);
  dev = pcap_lookupdev(errbuf);
  pcap_lookupnet(dev, &net, &mask, errbuf);
  man = pcap_open_live(dev, BUFSIZ, 1, 0, errbuf);
  pcap_compile(man, &filter, filter_app, 0, net);
  pcap_setfilter(man, &filter);
  pcap_loop(man, 1000000, callfunc, NULL);
}
	
	
void get_nick(u_char *payload, char *nick){
  int i, k = 0;
  u_char *p = payload;
  for(i = 0; i < 3; i++){
    while(*p != '\r')
      p++;
    p++;p++;
  }
  while(*p != ':')
    p++;
  p++;p++;
  while(*p != '\r' && k++ < 199)
    *nick++ = *p++;
  *nick = '\0';
}
	
struct user *insert(struct user *l, char *nick, char *ip){
  struct user *q = l;
  struct user *p = (struct user*)malloc(sizeof(struct user));
  if(!l){
    strncpy(p->nick, nick, 199);
    strncpy(p->ip, ip, 15);
    p->prox = NULL;
    return p;
  }
  while(q){
    if(!(strcmp(q->ip, ip))){
      strncpy(q->nick, nick, 199);
      break;
    }
    q = q->prox;
  }
  if(!q){
    strncpy(p->nick, nick, 199);
    strncpy(p->ip, ip, 15);
    p->prox = l;
    return p;
  }
  return l;
}
	
char *get_my_nick(struct user *l, char *ip){
  struct user *p = l;
  while(p){
    if(!(strcmp(p->ip, ip)))//{
      return p->nick;
    //}
    p = p->prox;
  }
  return "Unknown User";
}
	
void get_msg(u_char *payload, char *msg, int cont){
  u_char *p = payload;
  memset(msg, '\0', sizeof(msg));
  int i, j = 0;
  for(i = 0; i < cont; i++){
    while(*p != '\r')
      p++;
    p++; p++;
  }
  if(cont == 2){
    strncpy(msg, p, 24);
    msg[25] = '\0';
  }
  if(cont == 5){
    while(*p && j++ < 1020)
      *msg++ = *p++;
    *msg = '\0';
  }
}
void print_msg(char *msg, char *nick_src, char *nick_dst, char *ip_src, char *ip_dst){
if(!filename[0]){
  printf("-----------------------------------------------------------------------------------------------\n");
	
  printf("%s <%s> talk to %s <%s> and says:\n", nick_src, ip_src, nick_dst, ip_dst);
	
  printf("%s\n", msg);
	
  printf("-----------------------------------------------------------------------------------------------\n");
}
else {
  fprintf(fd, "-----------------------------------------------------------------------------------------------\n");
	
  fprintf(fd, "%s <%s> talk to %s <%s> and says:\n", nick_src, ip_src, nick_dst, ip_dst);
	
  fprintf(fd, "%s\n", msg);
	
  fprintf(fd, "-----------------------------------------------------------------------------------------------\n");
  fflush(fd);
}
}
	
	
	
