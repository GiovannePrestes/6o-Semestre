library verilog;
use verilog.vl_types.all;
entity Memoria_vlg_sample_tst is
    port(
        Bit_0           : in     vl_logic;
        Bit_1           : in     vl_logic;
        Bit_2           : in     vl_logic;
        Bit_3           : in     vl_logic;
        mem_read        : in     vl_logic;
        Mem_Write       : in     vl_logic;
        Sel_0           : in     vl_logic;
        Sel_1           : in     vl_logic;
        sampler_tx      : out    vl_logic
    );
end Memoria_vlg_sample_tst;
