create table HiddenLayerNodes(nodeNum int not null,inputNodeNum int not null, weight double not null);
create table OutputLayerNodes(nodeNum int not null,inputNodeNum int not null, weight double not null);
create table HiddenLayerBias(nodeNum int not null,biasValue double not null);
create table OutputLayerBias(nodeNum int not null,biasValue double not null);