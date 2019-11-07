library verilog;
use verilog.vl_types.all;
entity Memoria_vlg_check_tst is
    port(
        Out_Bit0        : in     vl_logic;
        Out_Bit1        : in     vl_logic;
        Out_Bit2        : in     vl_logic;
        Out_Bit3        : in     vl_logic;
        sampler_rx      : in     vl_logic
    );
end Memoria_vlg_check_tst;
